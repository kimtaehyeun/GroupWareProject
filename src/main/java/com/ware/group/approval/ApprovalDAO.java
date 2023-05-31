package com.ware.group.approval;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ware.group.annual.LeaveRecordVO;
import com.ware.group.approval3.DocumentFilesVO;
import com.ware.group.approval3.JobVO;
import com.ware.group.department.DepartmentVO;
import com.ware.group.member.MemberVO;

@Mapper
public interface ApprovalDAO {
	
public int addCategory(ApprovalCategoryVO approvalCategoryVO) throws Exception;
	
	public int addApprover(ApproverVO approverVO) throws Exception;
	
	public int addApprovalFormFile(ApprovalFormFileVO approvalFormFileVO) throws Exception;
	
	public List<ApprovalCategoryVO> getCategoryOption() throws Exception;
	
	public int deleteCategory(ApprovalCategoryVO categoryVO) throws Exception;
	
	public int updateCategory(ApprovalCategoryVO categoryVO) throws Exception;
	
	public List<ApprovalCategoryVO> getListCategoryRef0() throws Exception;
	
	public List<ApprovalCategoryVO> getListCategoryRef1() throws Exception;
	
	public ApprovalVO test() throws Exception;
	
	public List<DepartmentVO> getDepartmentList() throws Exception;
	
	public List<JobVO> getJobList(DepartmentVO departmentVO) throws Exception;
	
	public int addFormFile(DocumentFilesVO documentFilesVO) throws Exception;
	
	public long getFileId(String fileName) throws Exception;
	
	public String getCategoryDuplication(String name) throws Exception;
	
	public String getFileDuplication(String formFileName) throws Exception;
	
	public List<ApprovalFormFileVO> getListFormFile() throws Exception;
	
	public List<ApproverVO> getListApprover() throws Exception;
	
	public int updateFormFile(DocumentFilesVO documentFilesVO) throws Exception;
	
	public int updateCategoryName(ApprovalCategoryVO approvalCategoryVO) throws Exception;
	
	public int updateApprover(ApproverVO approverVO) throws Exception;
	
	//
	public List<ApprovalCategoryVO> getListCategory() throws Exception;
	
	public int setApprovalApplication(ApprovalVO approvalVO) throws Exception;
	
	public int setApprovalApplicationFileUpload(ApprovalUploadFileVO approvalUploadFileVO) throws Exception;
	
	public int setApprovalApplicationHistory(ApprovalHistoryVO approvalHistoryVO) throws Exception;
	
	public List<ApproverVO> getApprover(ApprovalVO approvalVO) throws Exception;
	
	public MemberVO getApprovalInfo(ApproverVO approverVO) throws Exception;
	
	public int setApprovalInfo(ApprovalInfoVO approvalInfoVO) throws Exception;
	
	public List<ApprovalVO> getApprovalList(ApprovalVO approvalVO) throws Exception;
	
	public ApprovalUploadFileVO getApprovalFile(ApprovalVO approvalVO) throws Exception;
	
	public int setInfoUpdate(ApprovalInfoVO approvalInfoVO) throws Exception;
	//자신의 id와 결재 번호로 자신의 순서를 조회
	public ApprovalInfoVO getInfoDetail(ApprovalInfoVO approvalInfoVO) throws Exception;
	//depth와 결재 번호로 다음 사람을 조회
	public ApprovalInfoVO getInfoList(ApprovalInfoVO approvalInfoVO) throws Exception;
	
	public int setApprovalUpdate(ApprovalVO approvalVO) throws Exception;
	
	public int setLeaverCode(LeaveRecordVO leaveRecordVO) throws Exception;
	
	//부서 번호 조회
	public MemberVO memberDepart(ApprovalVO approvalVO) throws Exception;
	
	public DepartmentVO departManager(MemberVO memberVO) throws Exception;
	
	public LeaveRecordVO getLeaverCode(LeaveRecordVO leaveRecordVO) throws Exception;
	
	public ApprovalVO getApprovalId(ApprovalVO approvalVO) throws Exception;
	
	public int setAnnual(LeaveRecordVO leaveRecordVO) throws Exception;
	
	public List<ApprovalVO> getMyApproval(ApprovalVO approvalVO) throws Exception;
	
	public ApprovalFormFileVO getFormFile(ApprovalCategoryVO approvalCategoryVO) throws Exception;
}
