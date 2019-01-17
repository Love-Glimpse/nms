package com.kuaidu.nms.financial.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kuaidu.nms.entity.PartnerWithdraw;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.financial.serviceImpl.WithdrawServiceImpl;
import com.kuaidu.nms.utils.fastdfs.FastDFSTemplate;
import com.kuaidu.nms.utils.fastdfs.FastDfsInfo;

@Controller
@RequestMapping("withdraw")
public class WithdrawController {
	@Autowired
	FastDFSTemplate fastDFSTemplate;

	
	@Autowired
	WithdrawServiceImpl withdrawService;
	
	
	@GetMapping("/index")
	public String withdrawIndex(HttpServletRequest request) {
		withdrawService.getWxAuthPartner(request);
		
		return "financial/withdraw";
	}
	
	
	
	@ResponseBody
	@GetMapping("")
	public Object getWithdraw(PartnerWithdraw partnerWithdraw,Integer page,Integer rows) {
		
		return withdrawService.getWithdraw(partnerWithdraw,page,rows);
	}
	
	
	
	@ResponseBody
	@GetMapping("payType")
	public Object getWithdrawPayType(@RequestParam()int id) {
		
		return withdrawService.getWithdrawPayType(id);
		
	}
	
	
	@ResponseBody
	@PostMapping("upload/voucher/{id}")
	public Object uploadVoucher(@PathVariable()Integer id,@RequestParam("voucher")MultipartFile file) throws IOException {
		try {
			String originalFilename = file.getOriginalFilename();
			if (originalFilename.equals("")) {
				return RestReturn.fail("文件没上传");
			}
			String type = FilenameUtils.getExtension(originalFilename);
			InputStream inputStream = file.getInputStream();
			byte[] byteArray = IOUtils.toByteArray(inputStream);
			FastDfsInfo fastDfsInfo = fastDFSTemplate.upload(byteArray, type);
			String fileAbsolutePath = fastDfsInfo.getFileAbsolutePath();
			return RestReturn.success(null,fileAbsolutePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return RestReturn.fail("上传失败");
	}
	
	
	/**
	 * 打款成功后提交
	 * @param id
	 * @param partnerWithdraw
	 * @return
	 */
	@ResponseBody
	@PostMapping("{id}")
	public Object paySuccess(@PathVariable()Integer id,PartnerWithdraw partnerWithdraw) {
		partnerWithdraw.setId(id);
		partnerWithdraw.setPay_time(new Date());
		partnerWithdraw.setStatus(1);
		return withdrawService.paySuccess(partnerWithdraw);
		
	}
}
