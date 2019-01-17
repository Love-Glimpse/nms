package com.kuaidu.nms.query.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.H5PushConfig;
import com.kuaidu.nms.entity.Ranking;

public interface H5PushConfigMapper {

	List<H5PushConfig> getH5PushConfigServicebySex(@Param("sex")Integer sex,@Param("moduleId") Integer moduleId);

	List<Ranking> getRankIngs();

	int updateCarouselMapUrl(@Param("bookId")Integer bookId,@Param("url") String fileAbsolutePath);

	int updateH5ConfigBook(@Param("id")Integer id, @Param("bookId")Integer bookId);

	int updateRanking(@Param("id")Integer id,@Param("bookId") Integer bookId);

}
