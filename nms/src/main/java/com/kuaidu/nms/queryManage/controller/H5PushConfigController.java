package com.kuaidu.nms.queryManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kuaidu.nms.entity.Book_list;
import com.kuaidu.nms.entity.H5PushConfig;
import com.kuaidu.nms.entity.Ranking;
import com.kuaidu.nms.entity.RestReturn;
import com.kuaidu.nms.query.serviceImpl.H5PushConfigServiceImpl;

@Controller
@RequestMapping("h5PushConfig")
public class H5PushConfigController {
	
	@Autowired
	H5PushConfigServiceImpl h5PushConfigService;
	

	@RequestMapping("")
	public String getAllConfig(Model model,@RequestParam(defaultValue="2")Integer sex,@RequestParam(defaultValue="0")Integer moduleId ){
		if (moduleId== 6) {
			List<Ranking> list = h5PushConfigService.getRankIngs();
			model.addAttribute("rankings", list);
			model.addAttribute("moduleName", "排行榜");
		}else{
			List<H5PushConfig> list = h5PushConfigService.getH5PushConfigServicebySex(sex,moduleId);
			model.addAttribute("h5PushConfigs", list);
			if (moduleId == 0) {
				model.addAttribute("moduleName", "全部模块");
			}else{
				String module_name = list.get(0).getModule_name();
				model.addAttribute("moduleName", module_name);
			}
		}
		model.addAttribute("sex", sex);
		if (sex == 2) {
			model.addAttribute("sexName", "全部频道");
		}else if (sex ==1) {
			model.addAttribute("sexName", "男频");
		}else {
			model.addAttribute("sexName", "女频");
		}
		model.addAttribute("moduleId", moduleId);
		return "Query/H5Config";
	}
	
	/**
	 *书本验证
	 * @param condition
	 * @return
	 */
	@ResponseBody
	@GetMapping("book")
	public List<Book_list> getBookNameAndPictureById(@RequestParam()String condition) {
		List<Book_list> list = h5PushConfigService.getBookNameAndPicture(condition);
		return list;
	}
	
	/**
	 * 修改轮播图
	 * @param file
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("upload/carouselMap")
	public RestReturn uploadCarouselMap(MultipartFile file,Integer id) {
		return  h5PushConfigService.uploadCarouselMap(file,id);
	}
	
	/**
	 * 修改bookId
	 * @param id
	 * @param bookId
	 * @return
	 */
	@ResponseBody
	@PutMapping("h5_push_config/{id}")
	public RestReturn updateH5ConfigBook(@PathVariable()Integer id,Integer bookId,Integer moduleId) {
		return h5PushConfigService.updateH5ConfigBook(id,bookId,moduleId);
	}
	
	
}
