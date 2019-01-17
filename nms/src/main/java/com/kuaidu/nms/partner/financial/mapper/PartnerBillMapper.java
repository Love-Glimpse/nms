package com.kuaidu.nms.partner.financial.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaidu.nms.entity.PartnerBill;

import tk.mybatis.mapper.common.Mapper;

public interface PartnerBillMapper extends Mapper<PartnerBill>{

	List<PartnerBill> statisticalBill();

	void saveEveryDayBill(List<PartnerBill> list);

	List<PartnerBill> getPartnerBillOneMonthByParentId(int parent_id);

	List<PartnerBill> getPartnerBillByPartnerId(int partner_id);

	List<PartnerBill> selssect();

	List<PartnerBill> getPartnerWithdrawInfoByParentId(int parent_id);

	List<PartnerBill> getEveryDayBillByParentId(@Param("parentId")int parent_id,@Param("status") Integer status);

	List<PartnerBill> getPendingBillByParentId(int parent_id);

	void updatePartnerBillStatus(@Param("list")List<PartnerBill> list,@Param("status") int i);

	List<PartnerBill> getPartnerWithdrawInfoByPartnerId(int partner_id);

	List<PartnerBill> getPendingBillByPartnerId(int partner_id);

	List<PartnerBill> getEveryDayBillByPartnerId(@Param("partnerId")int partner_id,@Param("status")Integer status);

	PartnerBill getPartnerBillById(Integer id);

	PartnerBill getParentBillById(Integer id);



}
