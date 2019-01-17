package com.kuaidu.nms.queryManage.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuaidu.nms.entity.Author;
import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.Novel_type;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.query.serviceImpl.BooksQueryMapperImpl;
import com.kuaidu.nms.query.serviceImpl.ChpterServerImpl;
import com.kuaidu.nms.utils.Log4jUtil;
import com.kuaidu.nms.utils.ResultData;
import com.kuaidu.nms.utils.Utils;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;
import com.kuaidu.nms.utils.fastdfs.FastDfsInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/booksQuery")
public class BooksQueryManage {
	@Autowired
	private BooksQueryMapperImpl bImpl;

	@Autowired
	ChpterServerImpl chpterServerImpl;
	@Resource
	FastDFSTemplate fastDFSTemplate;

	@RequestMapping("/booksQueryIndex")
	public ModelAndView booksQueryManageIndex(HttpSession session) {

		ModelAndView mv = new ModelAndView();
		try {
			List<Novel_type> novel_types = bImpl.getAllnovel_type();
			mv.addObject("novel_types", novel_types);
			mv.setViewName("Query/booksQurey");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * 
	 * 
	 * 
	 * 使用了分页的话，其框架自身会向后台传递page、rows这个两个属性值。 分别表示当前页和当前页显示的记录行数。
	 * 可以在action中定义好这两个属性，并同样设置getter和setter方法，就可以接受到这些参数了。
	 */
	// 查
	@ResponseBody
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request, Book_list bList) {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		Integer start_rows = Integer.parseInt(page) * Integer.parseInt(rows) - Integer.parseInt(rows);
		bList.setStart_rows(start_rows);
		bList.setEnd_rows(Integer.parseInt(rows));
		List<Book_list> list = bImpl.getAllbooks(bList);
		int total = bImpl.getCount(bList);
		return ResultData.toJsonString(total, list);
	}

	/*
	 * 新增书籍,编辑书籍
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/add_bList")
	public String add_bList(HttpServletRequest request, Book_list bList) throws UnknownHostException {
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		String imgUrl = bList.getBook_pic_url();
		int book_id = bList.getBook_id();
		try {
			int getSameCount = bImpl.getSameCount(bList);
			if (getSameCount != 0) {
				if (book_id <= 0) {
					json.put("result", "2");
					return jArray.toString();
				}

			}
			// 作者ID判断及生成
			// 作者表
			Author author = new Author();
			author.setAuthor_name(bList.getAuthor());
			author.setGroup_type(1);
			List<Author> authors = bImpl.getAllAuthors(author);
			// 查询作者是否存在
			if (authors.size() != 0) {
				// 存在，则取id
				for (Author s : authors) {
					int a_id = s.getAuthor_id();
					bList.setAuthor_id(a_id);
				}
			} else {
				// 如果不存在则创建新作家
				bImpl.add_author(author);
				// 创建之后再取其ID
				List<Author> author1 = bImpl.getAllAuthors(author);
				for (Author s : author1) {
					int a_id = s.getAuthor_id();
					bList.setAuthor_id(a_id);
				}
			}

			// bList.setTotal_chapter_count(jObject.getInt("total_chapter_count"));
			bList.setSource_ids(",99,");

			// 如果为添加，id为空则执行这里
			if (book_id <= 0) {
				// 调用添加接口函数
				bImpl.add_bList(bList);
			} else {
				// 如果为编辑。则获取行的书号book_id，则不为空，执行这里
				bList.setBook_id(book_id);
				// 调用编辑接口函数
				bImpl.edit_bList(bList);
			}
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		} finally {
			jArray.add(json.toString());
			return jArray.toString();
		}
	}

	/*
	 * 删除书
	 */
	// suppresswarnings：抑制finally警告
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/del_bList")
	public String del_user(HttpServletRequest request) throws UnknownHostException {
		String node = request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < jsonArray.size(); i++) {
				list.add(jsonArray.get(i));
			}
			bImpl.del_bList(list);
			jsonObject.put("result", "0");

		} catch (Exception e) {
			jsonObject.put("result", "1");
			e.printStackTrace();

		} finally {
			jArray.add(jsonObject.toString());
			return jArray.toString();
		}
	}

	@ResponseBody
	@RequestMapping("/check_ok")
	public String checkOk(Book_list book_list) {
		JSONObject jsonObject = new JSONObject();
		try {
			bImpl.checkOk(book_list);
			jsonObject.put("result", "0");

		} catch (Exception e) {
			jsonObject.put("result", "1");
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@ResponseBody
	@RequestMapping("/update_remark")
	public String updateRemark(Book_list book_list) {
		JSONObject jsonObject = new JSONObject();
		try {
			bImpl.updateRemark(book_list);
			jsonObject.put("result", "0");

		} catch (Exception e) {
			jsonObject.put("result", "1");
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	/**
	 *
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("downNoPic")
	public void downloadFiles(HttpServletRequest request, HttpServletResponse response) {
		// 响应头的设置
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 设置压缩包的名字
		// 解决不同浏览器压缩包名字含有中文时乱码的问题
		String downloadName = "我是压缩包的名字.zip";
		String agent = request.getHeader("USER-AGENT");
		try {
			if (agent.contains("MSIE") || agent.contains("Trident")) {
				downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
			} else {
				downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

		// 设置压缩流：直接写入response，实现边压缩边下载
		ZipArchiveOutputStream zipos = null;
		try {
			zipos = new ZipArchiveOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Book_list> list = bImpl.getNoPic();
		// 循环将文件写入压缩流
		DataOutputStream os = null;
		for (Book_list bookList : list) {
			try {
				URL url = new URL(bookList.getBook_pic_url());
				// 打开连接
				URLConnection con = url.openConnection();
				con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				// 设置请求超时为5s
				con.setConnectTimeout(5 * 1000);
				// 输入流
				InputStream is = con.getInputStream();
				byte[] byteArray = IOUtils.toByteArray(is);
				String contentType = con.getContentType();
				String type = StringUtils.substringAfter(contentType, "/");
				if (!type.equalsIgnoreCase("jpg")  && !type.equalsIgnoreCase("png")
						&& !type.equalsIgnoreCase("bmp")) {
					type = "jpg";
				}
				ZipArchiveEntry zipEntry = new ZipArchiveEntry(bookList.getBook_id() + "." + type);
				zipEntry.setSize(byteArray.length);
				zipos.putArchiveEntry(zipEntry);
				os = new DataOutputStream(zipos);
				IOUtils.write(byteArray, os);
				is.close();
				zipos.closeArchiveEntry();
			} catch (IOException e) {
			}
		}
		try {
			os.flush();
			os.close();
			zipos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据bookId获取下载图片
	 * 
	 * @param ids
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("downPic")
	public void downloadBookPic(@RequestParam() String ids, HttpServletRequest request, HttpServletResponse response) {
		String[] split = ids.split("-");
		if (split.length == 0) {
			return;
		}

		// 响应头的设置
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 设置压缩包的名字
		// 解决不同浏览器压缩包名字含有中文时乱码的问题
		String downloadName = "我是压缩包的名字.zip";
		String agent = request.getHeader("USER-AGENT");
		try {
			if (agent.contains("MSIE") || agent.contains("Trident")) {
				downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
			} else {
				downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

		// 设置压缩流：直接写入response，实现边压缩边下载
		ZipArchiveOutputStream zipos = null;
		try {
			zipos = new ZipArchiveOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Book_list> list = bImpl.getPicByIds(split);

		// 循环将文件写入压缩流
		DataOutputStream os = null;
		for (Book_list bookList : list) {
			try {
				URL url = new URL(bookList.getBook_pic_url());
				// 打开连接
				URLConnection con = url.openConnection();
				con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
				// 设置请求超时为5s
				con.setConnectTimeout(5 * 1000);
				// 输入流
				InputStream is = con.getInputStream();
				byte[] byteArray = IOUtils.toByteArray(is);
				String contentType = con.getContentType();
				String type = StringUtils.substringAfter(contentType, "/");
				if (!type.equalsIgnoreCase("jpg") &&  !type.equalsIgnoreCase("png")
						&& !type.equalsIgnoreCase("bmp")) {
					type = "jpg";
				}
				ZipArchiveEntry zipEntry = new ZipArchiveEntry(bookList.getBook_id() + "." + type);
				zipEntry.setSize(byteArray.length);
				zipos.putArchiveEntry(zipEntry);
				os = new DataOutputStream(zipos);
				IOUtils.write(byteArray, os);
				is.close();
				zipos.closeArchiveEntry();
			} catch (IOException e) {
			}
		}
		try {
			os.flush();
			os.close();
			zipos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传原图图片
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@PostMapping("uploadPic")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception {
		String name2 = file.getOriginalFilename();
		if (name2.contains(".zip")) {
			ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(file.getInputStream());
			ZipArchiveEntry zipEntry = zipInputStream.getNextZipEntry();

			while (zipEntry != null) { // 获取zip包中的每一个zip
				try {
					String zipFileName = zipEntry.getName();
					String extension = FilenameUtils.getExtension(zipFileName);
					String name = FilenameUtils.getBaseName(zipFileName);
					Integer bookId = Integer.parseInt(name);
					OutputStream os = null;
					try {
						byte[] byteArray = IOUtils.toByteArray(zipInputStream);
						FastDfsInfo upload = fastDFSTemplate.upload(byteArray, extension);
						String fileAbsolutePath = upload.getFileAbsolutePath();
						String bookPic = bImpl.getbookPicById(bookId);
						if (bookPic != null) {
							try {
								fastDFSTemplate.deleteFile(bookPic);
							} catch (Exception e) {
							}
						}
						String substringBefore = StringUtils.substringBefore(fileAbsolutePath, "?");
						bImpl.updateBookPic(bookId, substringBefore);
					} finally {
						IOUtils.closeQuietly(os);
					}

				} catch (NumberFormatException e) {
				}catch (Exception e) {
					Log4jUtil.getSimpleErrorLogger().error("", e);
				}
				zipEntry = zipInputStream.getNextZipEntry();
			}

		} else {

			try {
				String name = FilenameUtils.getBaseName(name2);
				String type = FilenameUtils.getExtension(name2);
				Integer bookId = Integer.parseInt(name);
				InputStream is = file.getInputStream();
				byte[] data = IOUtils.toByteArray(is);
				FastDfsInfo upload = fastDFSTemplate.upload(data, type);
				String bookPic = bImpl.getbookPicById(bookId);
				try {
					fastDFSTemplate.deleteFile(bookPic);
				} catch (Exception e) {
				}
				String fileAbsolutePath = upload.getFileAbsolutePath();
				String substringBefore = StringUtils.substringBefore(fileAbsolutePath, "?");
				bImpl.updateBookPic(bookId, substringBefore);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:picutrePage";
	}

	/**
	 * 
	 * 上传压缩后图片
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping("uploadSmallPic")
	public String upload2(@RequestParam("file") MultipartFile file) throws IOException {
		String name2 = file.getOriginalFilename();
		if (name2.contains(".zip")) {
			ZipArchiveInputStream zipInputStream = new ZipArchiveInputStream(file.getInputStream());
			ZipArchiveEntry zipEntry = zipInputStream.getNextZipEntry();
			while (zipEntry != null) { // 获取zip包中的每一个zip
				try {
					String zipFileName = zipEntry.getName();
					String type = FilenameUtils.getExtension(zipFileName);
					String name = FilenameUtils.getBaseName(zipFileName);
					Integer bookId = Integer.parseInt(name);
					OutputStream os = null;
					try {
						byte[] byteArray = IOUtils.toByteArray(zipInputStream);
						FastDfsInfo upload = fastDFSTemplate.upload(byteArray, type);
						String fileAbsolutePath = upload.getFileAbsolutePath();
						String bookPic = bImpl.getBookSmallPic(name);
						if (bookPic != null) {
							try {
								fastDFSTemplate.deleteFile(bookPic);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						String substringBefore = StringUtils.substringBefore(fileAbsolutePath, "?");
						bImpl.updateBooksmallPic(bookId, substringBefore);
					} finally {
						IOUtils.closeQuietly(os);
					}
				}catch (NumberFormatException e) {
				}catch (Exception e) {
					Log4jUtil.getSimpleErrorLogger().error("", e);
				}
				zipEntry = zipInputStream.getNextZipEntry();
			}
		} else {
			try {
				String name = FilenameUtils.getBaseName(name2);
				String type = FilenameUtils.getExtension(name2);
				Integer bookId = Integer.parseInt(name);
				InputStream is = file.getInputStream();
				byte[] data = IOUtils.toByteArray(is);
				FastDfsInfo upload = fastDFSTemplate.upload(data, type);
				String bookPic = bImpl.getBookSmallPic(name);
				try {
					fastDFSTemplate.deleteFile(bookPic);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String fileAbsolutePath = upload.getFileAbsolutePath();
				String substringBefore = StringUtils.substringBefore(fileAbsolutePath, "?");
				bImpl.updateBooksmallPic(bookId, substringBefore);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:picutrePage";
	}

	/**
	 * 
	 * 跳转到章节审核页面
	 * 
	 * @return
	 */
	@RequestMapping("checkContent")
	public String checkContent(HttpServletRequest request) {
		String book_name = request.getParameter("book_name");
		return "Query/chapterView";
	}

	/**
	 * 
	 * 跳转到图片管理页面
	 * 
	 * @return
	 */
	@RequestMapping("picutrePage")
	public String picutrePage() {
		return "Query/bookPic";
	}

	/**
	 * 获取图片
	 * 
	 * @param pn
	 * @return
	 */
	@ResponseBody
	@RequestMapping("picture")
	public PageInfo<Book_list> getBookPic(@RequestParam(defaultValue = "1") Integer pn,
			@RequestParam() Integer changed) {
		PageHelper.startPage(pn, 200);
		List<Book_list> list = bImpl.getbookPic(changed);
		PageInfo<Book_list> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * 下载单个图片
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("down/{id}")
	public ResponseEntity<byte[]> downloadOnePic(@PathVariable() Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		String picUrl = bImpl.getBookPicUrl(id);
		try {
			URL url = new URL(picUrl);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();
			String contentType = con.getContentType();
			String type = StringUtils.substringAfter(contentType, "/");
			if (!type.equalsIgnoreCase("jpg") &&  !type.equalsIgnoreCase("png")
					&& !type.equalsIgnoreCase("bmp")) {
				type = "jpg";
			}
			//String type = StringUtils.substringAfterLast(contentType, "/");
			// 1K的数据缓冲
			byte[] byteArray = IOUtils.toByteArray(is);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=" + id + "."+type);
			headers.add("Content-Type", contentType);
			HttpStatus status = HttpStatus.OK;
			ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(byteArray, headers, status);
			return entity;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@RequestMapping("aas")
	public void downloadBook(HttpServletRequest request, HttpServletResponse response) {
		// 响应头的设置
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 设置压缩包的名字
		// 解决不同浏览器压缩包名字含有中文时乱码的问题
		String downloadName = "我是原图.zip";
		String agent = request.getHeader("USER-AGENT");
		try {
			if (agent.contains("MSIE") || agent.contains("Trident")) {
				downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
			} else {
				downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

		// 设置压缩流：直接写入response，实现边压缩边下载
		ZipOutputStream zipos = null;
		try {
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Book_list> list = bImpl.getpic();

		// 循环将文件写入压缩流
		DataOutputStream os = null;
		for (Book_list bookList : list) {
			try {
				URL url = new URL(bookList.getPic_path());
				// 打开连接
				URLConnection con = url.openConnection();
				String contentType = con.getContentType();
				String type = StringUtils.substringAfter(contentType, "/");
				// 设置请求超时为5s
				con.setConnectTimeout(10 * 1000);
				// 输入流
				InputStream is = con.getInputStream();
				zipos.putNextEntry(new ZipEntry(bookList.getBook_id() + "."+type));
				os = new DataOutputStream(zipos);

				byte[] b = new byte[100];
				int length = 0;
				while ((length = is.read(b)) != -1) {
					os.write(b, 0, length);
				}
				is.close();
				zipos.closeEntry();
			} catch (IOException e) {
			}
		}
		try {
			os.flush();
			os.close();
			zipos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping("as")
	public void downlodadBook(HttpServletRequest request, HttpServletResponse response) {
		// 响应头的设置
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		// 设置压缩包的名字
		// 解决不同浏览器压缩包名字含有中文时乱码的问题
		String downloadName = "我是压缩图.zip";
		String agent = request.getHeader("USER-AGENT");
		try {
			if (agent.contains("MSIE") || agent.contains("Trident")) {
				downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
			} else {
				downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

		// 设置压缩流：直接写入response，实现边压缩边下载
		ZipOutputStream zipos = null;
		try {
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Book_list> list = bImpl.getsmall();

		// 循环将文件写入压缩流
		DataOutputStream os = null;
		for (Book_list bookList : list) {
			try {
				URL url = new URL(bookList.getSmall_pic());
				// 打开连接
				URLConnection con = url.openConnection();
				// 设置请求超时为5s
				con.setConnectTimeout(10 * 1000);
				String contentType = con.getContentType();
				String type = StringUtils.substringAfter(contentType, "/");
				// 输入流
				InputStream is = con.getInputStream();
				zipos.putNextEntry(new ZipEntry(bookList.getBook_id() + "."+type));
				os = new DataOutputStream(zipos);

				byte[] b = new byte[100];
				int length = 0;
				while ((length = is.read(b)) != -1) {
					os.write(b, 0, length);
				}
				is.close();
				zipos.closeEntry();
			} catch (IOException e) {
			}
		}
		try {
			os.flush();
			os.close();
			zipos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping("bookClear")
	public JSONObject bookClear(HttpServletRequest request, HttpSession session, @RequestParam() Integer book_id,
			@RequestParam() String book_name) {
		int ret = 0;
		JSONObject jsonRet = new JSONObject();
		Sys_user sys_user = Utils.getSysUserFromSession(session);
		if (sys_user == null) {
			jsonRet.put("result", 5);
			return jsonRet;
		}
		ret = bImpl.bookClear(book_id, book_name);
		jsonRet.put("result", ret);
		return jsonRet;
	}

	@ResponseBody
	@RequestMapping("getUrlFromRzlib")
	public JSONObject getUrlFromRzlib(HttpServletRequest request, @RequestParam() String book_name)
			throws UnsupportedEncodingException {
		return BooksQueryMapperImpl.getUrlFromRzlib(book_name);
	}

	@ResponseBody
	@RequestMapping("editReadOriginalChapter")
	public JSONObject editReadOriginalChapter(HttpServletRequest request, @RequestParam() Integer book_id,
			@RequestParam() Integer chapter_num) throws UnsupportedEncodingException {

		JSONObject jsonRet = new JSONObject();
		int ret = bImpl.editReadOriginalChapter(book_id, chapter_num);
		jsonRet.put("result", ret);
		return jsonRet;
	}

	@ResponseBody
	@RequestMapping("editSubscribeChapter")
	public JSONObject editSubscribeChapter(HttpSession session, @RequestParam() Integer book_id,
			@RequestParam() Integer chapter_num) throws UnsupportedEncodingException {
		JSONObject jsonRet = new JSONObject();
		int partner_id = 0;
		String login_flag = (String) session.getAttribute("login_flag");
		if (login_flag.equalsIgnoreCase("system")) {
			Sys_user sys_user = Utils.getSysUserFromSession(session);
			if (sys_user == null) {
				return jsonRet;
			}
		} else if (login_flag.equalsIgnoreCase("partner")) {
			PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
			if (partnerInfo == null) {
				return jsonRet;
			}
			partner_id = partnerInfo.getPartner_id();
		}
		int ret = bImpl.editSubscribeChapter(partner_id, book_id, chapter_num);
		jsonRet.put("result", ret);
		return jsonRet;
	}
}
