package com.kuaidu.nms.queryManage.controller;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaidu.nms.entity.Author;
import com.kuaidu.nms.query.serviceImpl.AuthorsQueryMapperImpl;
import com.kuaidu.nms.utils.ResultData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/authorsQurey")
public class AuthorsQueryManage {
	@Autowired
	private AuthorsQueryMapperImpl aImpl;
	
	public AuthorsQueryMapperImpl getrImpl() {
		return aImpl;
	}
	public void setrImpl(AuthorsQueryMapperImpl aImpl) {
		this.aImpl = aImpl;
	}
	@RequestMapping("/authorsQueryIndex")
	public ModelAndView authorsQueryManageIndex(HttpSession session){
		
			ModelAndView mv = new ModelAndView();
			
		try {
			mv.setViewName("Query/authorsQuery"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	/*
	 * datagrid使用了分页的话，其框架自身会向后台传递page、rows这个两个属性值。
	 * 分别表示当前页和当前页显示的记录行数。
	 * 可以在action中定义好这两个属性，并同样设置getter和setter方法，就可以接受到这些参数了。
	 * */
	//查
	@ResponseBody
	@RequestMapping("/getAllAuthor")
	public String getAll(HttpServletRequest request){	
		String page= request.getParameter("page");	
		String rows= request.getParameter("rows");
		/**/
		Integer start_rows = Integer.parseInt(page)*Integer.parseInt(rows)-Integer.parseInt(rows);
		
		Author aList = new Author();
		
		aList.setAuthor_name(request.getParameter("author_name"));
		
		aList.setStart_rows(start_rows);
		aList.setEnd_rows(Integer.parseInt(rows));
		
		List<Author> list = aImpl.getAllAuthors(aList);
		int total = aImpl.getCount(aList);
		System.out.println(ResultData.toJsonString(total, list));
		return ResultData.toJsonString(total, list);
	}
	/*
	 * 新增书籍,编辑书籍
	 */
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/add_aList")
	public String add_aList(HttpServletRequest request) throws UnknownHostException{
		//接受json对象，转化为字符串
		String node = request.getParameter("node");
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			Author aList = new Author();
			//将node数组里的字符串转换为json对象
			JSONObject jObject = JSONObject.fromObject(node);
			//将json字符串转化存储
			String author_id = jObject.getString("author_id");
			aList.setAuthor_name(jObject.getString("author_name"));
			aList.setGroup_type(jObject.getInt("group_type"));
			/*作者ID判断及生成
			作者表
			Author author = new Author();
			author.setAuthor_name(aList.getAuthor());
			author.setPenname(aList.getAuthor());
			author.setGroup_type(1);
			List<Author> authors = aImpl.getAllAuthors(aList);
			if(authors.size()!=0){
				for(Author s : authors){
					int a_id = s.getAuthor_id();
					bList.setAuthor_id(a_id);
					System.out.println(a_id);
				}
			}else {
				aImpl.add_author(author);
				List<Author> author1 = aImpl.getAllAuthors(author);
				for(Author s : author1){
					int a_id = s.getAuthor_id();
					bList.setAuthor_id(a_id);
					System.out.println(a_id);
					}
			}*/
			if(author_id==null || "".equals(author_id)){
				//调用添加接口函数
				aImpl.add_aList(aList);
			}else{
				//如果为编辑。则获取行的书号book_id，则不为空，执行这里
				aList.setAuthor_id(Integer.parseInt(author_id));
				//调用编辑接口函数
				aImpl.edit_aList(aList);
			}
			json.put("result", "0");
		} catch (Exception e) {
			json.put("result", "1");
			e.printStackTrace();
		}finally{
			jArray.add(json.toString());
			return jArray.toString();
		}
	}
	
	/*
	 * 删除作家
	 */
	//suppresswarnings：抑制finally警告
	@SuppressWarnings("finally")
	@ResponseBody
	@RequestMapping("/del_aList")
	public String del_aList(HttpServletRequest request) throws UnknownHostException{
		String node =request.getParameter("node");
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			JSONArray jsonArray = JSONArray.fromObject(node);  
	        List<Object> list= new ArrayList<Object>();
	        for(int i=0;i<jsonArray.size();i++){
	            list.add(jsonArray.get(i));
	        }
	        System.out.println(list);
	        aImpl.del_aList(list);
	        jsonObject.put("result", "0");
	        
		} catch (Exception e) {
			 jsonObject.put("result", "1");
			e.printStackTrace();
			
		}finally {
			jArray.add(jsonObject.toString());
			return jArray.toString();
		}
	}
}
