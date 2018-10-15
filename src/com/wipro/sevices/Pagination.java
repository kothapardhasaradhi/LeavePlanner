package com.wipro.sevices;

import java.util.ArrayList;

import com.wipro.leave.LeaveVO;

public class Pagination {

public boolean EmpLeaveDetailsPagination(LeaveVO leaveDetailsVo) {
int maxRecordCount = 10;

ArrayList<LeaveVO> retrieveLeavePagination = new ArrayList<LeaveVO>();
String levDate = "";
int topRow = 0;
int lstSize = leaveDetailsVo.getDuplicateList().size();

if ("null".equalsIgnoreCase(leaveDetailsVo.getMethod())) {
leaveDetailsVo.setMethod("first");
}
if(lstSize <= maxRecordCount)
{
	leaveDetailsVo.setMethod("first");	
}

if ("next".equals(leaveDetailsVo.getMethod())) {

int newTop = ((int) leaveDetailsVo.getPageNumber() * maxRecordCount);

int currentPage = 0;
if((lstSize % maxRecordCount) == 0)
{
currentPage = (lstSize / maxRecordCount) - 1;
}else{
currentPage = (lstSize / maxRecordCount);
}
if(lstSize <= maxRecordCount)
{
currentPage = 0;
}

if ((lstSize - 1) <= ((int) leaveDetailsVo.getPageNumber() * maxRecordCount)
+ (maxRecordCount - 1)) {
leaveDetailsVo.setPageNumber(currentPage);
leaveDetailsVo.setMethod("last");
return false;
}

else if (lstSize > newTop) {
topRow = newTop;

int nextTop = topRow + maxRecordCount;
int maxNoOfRecords = maxRecordCount + (topRow + maxRecordCount);
leaveDetailsVo
.setPageNumber(leaveDetailsVo.getPageNumber() + 1);

int var;

if ((topRow + maxRecordCount) <= lstSize) {
int topRowTemp = topRow;
int temp = 0;
while (topRowTemp < (topRow + maxRecordCount)) {
if (maxNoOfRecords > lstSize) {
var = (maxRecordCount + (topRow + maxRecordCount))
- lstSize;
topRowTemp += var;
maxNoOfRecords = 0;
continue;
} else if (nextTop < lstSize) {

LeaveVO vo = new LeaveVO();

vo.setEmpid(leaveDetailsVo.getDuplicateList()
.get(nextTop).getEmpid());

vo.setEmpname(leaveDetailsVo.getDuplicateList()
.get(nextTop).getEmpname());
//levDate = leaveDetailsVo.getDuplicateList()
//.get(nextTop).getTodate();
vo.setTodate(leaveDetailsVo.getDuplicateList()
.get(nextTop).getTodate());
//  levDate = leaveDetailsVo.getDuplicateList()
//.get(nextTop).getFromdate();
vo.setFromdate(leaveDetailsVo.getDuplicateList()
.get(nextTop).getFromdate());
vo.setBackupres(leaveDetailsVo.getDuplicateList()
.get(nextTop).getBackupres());
vo.setLeavetype(leaveDetailsVo.getDuplicateList()
.get(nextTop).getLeavetype());
retrieveLeavePagination.add(vo);

nextTop += 1;

}
topRowTemp += 1;
}

}
}

} else if ("previous".equals(leaveDetailsVo.getMethod())) {

topRow = 0;
int newTop = ((int) leaveDetailsVo.getPageNumber() * maxRecordCount);
if (newTop > 0) {
topRow = newTop;

leaveDetailsVo
.setPageNumber(leaveDetailsVo.getPageNumber() - 1);

int prevPageRow = ((int) leaveDetailsVo.getPageNumber() * maxRecordCount);
int temp = 0;
while (prevPageRow < topRow) {

LeaveVO vo = new LeaveVO();

vo.setEmpid(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getEmpid());

vo.setEmpname(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getEmpname());
//levDate = leaveDetailsVo.getDuplicateList()
//.get(prevPageRow).getTodate();
vo.setTodate(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getTodate());
//levDate = leaveDetailsVo.getDuplicateList()
//.get(prevPageRow).getFromdate();
vo.setFromdate(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getFromdate());
vo.setBackupres(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getBackupres());
vo.setLeavetype(leaveDetailsVo.getDuplicateList()
.get(prevPageRow).getLeavetype());
retrieveLeavePagination.add(vo);

prevPageRow += 1;
}

}

else {
topRow = 0;

leaveDetailsVo.setPageNumber(0);
leaveDetailsVo.setMethod("first");
return false;

}
} else if ("first".equals(leaveDetailsVo.getMethod())) {
topRow = 0;
int flag = 0;

leaveDetailsVo.setPageNumber(0);
if (lstSize > 0) {
while (topRow < maxRecordCount) {
System.out.println("entered while" + "..... topRow "
+ topRow + " MaxRecordCount " + maxRecordCount);
if (leaveDetailsVo.getDuplicateList().size() > flag) {

LeaveVO vo = new LeaveVO();

vo.setEmpid(leaveDetailsVo.getDuplicateList().get(flag)
.getEmpid());

vo.setEmpname(leaveDetailsVo.getDuplicateList()
.get(flag).getEmpname());

//  levDate = leaveDetailsVo.getDuplicateList().get(flag)
//  .getTodate();
vo.setTodate(leaveDetailsVo.getDuplicateList().get(flag)
.getTodate());
//  levDate = leaveDetailsVo.getDuplicateList().get(flag)
//.getFromdate();
vo.setFromdate(leaveDetailsVo.getDuplicateList().get(flag)
.getFromdate());

vo.setBackupres(leaveDetailsVo.getDuplicateList()
.get(flag).getBackupres());


vo.setLeavetype(leaveDetailsVo.getDuplicateList()
.get(flag).getLeavetype());

retrieveLeavePagination.add(vo);
flag += 1;

}
topRow += 1;
}

flag = 0;

}

}

else if ("last".equals(leaveDetailsVo.getMethod())) {

topRow = 0;
int lastPageNo = 0;
if((lstSize % maxRecordCount) == 0)
{
lastPageNo = (lstSize / maxRecordCount) - 1;
}else{
lastPageNo = (lstSize / maxRecordCount);
}
if(lstSize <= maxRecordCount)
{
lastPageNo = 0;
}
if ((lstSize - 1) <= ((int) leaveDetailsVo.getPageNumber() * maxRecordCount)
+ (maxRecordCount - 1)) {
leaveDetailsVo.setPageNumber(lastPageNo);
leaveDetailsVo.setMethod("last");
return false;
}
leaveDetailsVo.setPageNumber(lastPageNo);
int pageRecord = 0;
int temp = lastPageNo * maxRecordCount;
while (temp < lstSize) {
if (pageRecord < (lastPageNo * maxRecordCount)) {

pageRecord += 1;
continue;
}

else if (pageRecord < lstSize) {
LeaveVO vo = new LeaveVO();

vo.setEmpid(leaveDetailsVo.getDuplicateList()
.get(pageRecord).getEmpid());

vo.setEmpname(leaveDetailsVo.getDuplicateList()
.get(pageRecord).getEmpname());
//  levDate = leaveDetailsVo.getDuplicateList().get(pageRecord)
//.getTodate();
vo.setTodate(leaveDetailsVo.getDuplicateList().get(pageRecord)
.getTodate());
//  levDate = leaveDetailsVo.getDuplicateList().get(pageRecord)
//.getFromdate();
vo.setFromdate(leaveDetailsVo.getDuplicateList().get(pageRecord)
.getFromdate());
vo.setBackupres(leaveDetailsVo.getDuplicateList()
.get(pageRecord).getBackupres());
vo.setLeavetype(leaveDetailsVo.getDuplicateList()
.get(pageRecord).getLeavetype());
retrieveLeavePagination.add(vo);
pageRecord += 1;
}

temp += 1;
}

}

LeaveVO.setListVO(retrieveLeavePagination);

return true;
}
}
