package com.pavilionking.wcm.common.constant;

/**   
 * @ClassName:  PageUtils   
 * @Description:TODO(分页封装)   
 * @author: CLONG
 * @date:   2018年10月8日 下午3:42:33  
 * @Copyright: 2018 www.derlte.com Inc. All rights reserved. 
 * 注意：本内容仅限于天津德尔塔科技有限公司内部传阅，禁止外泄以及用于其他的商业目 
 */  
public class PageUtils {

	private Integer currtPage;
	
	private Long totalPage;
	
	private Long count;
	
	private Integer startNum;
	
	private Integer rows;

	public Integer getCurrtPage() {
		return currtPage;
	}

	public void setCurrtPage(Integer currtPage) {
		if(currtPage==null){
			currtPage = 10;
		}
		this.currtPage = currtPage;
	}

	public Long getTotalPage(Long count) {
			this.count = count;
			totalPage = count % rows == 0 ? count /rows : count / rows + 1; 
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getRows() {
		if(currtPage==null){
			currtPage = 10;
		}
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public PageUtils(Integer currtPage, Long totalPage, Long count, Integer startNum, Integer rows) {
		super();
		this.currtPage = currtPage;
		this.totalPage = totalPage;
		this.count = count;
		this.startNum = startNum;
		this.rows = rows;
	}
	
	public PageUtils(Integer currtPage, Integer rows) {
		super();
		if(currtPage==null){
			currtPage = 1;
		}
		if(rows==null){
			rows = 10;
		}
		this.currtPage = currtPage;
		this.rows = rows;
		this.startNum = (currtPage-1)*rows;
	}

	public PageUtils() {
	}
	
	
}
