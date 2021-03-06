package com.xnx3.wangmarket.admin.bean;

import java.util.Map;
import com.xnx3.wangmarket.im.entity.Im;
import com.xnx3.wangmarket.admin.entity.InputModel;
import com.xnx3.wangmarket.admin.entity.Site;
import com.xnx3.wangmarket.admin.entity.SiteColumn;
import com.xnx3.wangmarket.admin.vo.TemplateVarVO;
import com.xnx3.wangmarket.superadmin.entity.Agency;

/**
 * 用户登录后，即跟随用户Session一块的缓存，其在Shiro中
 * @author 管雷鸣
 */
public class UserBean {
	private Agency myAgency;		//我的代理信息，如果我是代理的话，才有内容
	private Site site;		//当前用户的站点信息
	private Agency parentAgency;	//我的上级代理信息，当前用户的上级代理信息
	private Map<String, String> templateVarCompileDataMap;	//我当前高级模式使用的模版变量，可能是已被编译(替换)过标签的内容了。key:template.name	value:模版变量的内容
	private Map<String, TemplateVarVO> templateVarMapForOriginal;	//原始的模版变量，其内包含模版变量的数据库中的原始内容. key:templateVar.name 
	private Map<Integer, SiteColumn> siteColumnMap;		//缓存的当前用户的栏目信息 key:siteColumn.id（CMS模式才会使用此缓存）登录时不会缓存此处，在使用时才会缓存
	private Map<Integer, InputModel> inputModelMap;	//当前CMS网站的输入模型，由 inputModelService 初始化赋予值。在用户进入内容管理，编辑时才会判断，如果此为null，才会从数据库加载数据
	private Im im;		//网站客服，进行缓存到这里
	
	public Agency getMyAgency() {
		return myAgency;
	}
	public void setMyAgency(Agency myAgency) {
		this.myAgency = myAgency;
	}
	public Agency getParentAgency() {
		return parentAgency;
	}
	public void setParentAgency(Agency parentAgency) {
		this.parentAgency = parentAgency;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}

	public Map<Integer, SiteColumn> getSiteColumnMap() {
		return siteColumnMap;
	}
	public void setSiteColumnMap(Map<Integer, SiteColumn> siteColumnMap) {
		this.siteColumnMap = siteColumnMap;
	}
	public Map<Integer, InputModel> getInputModelMap() {
		return inputModelMap;
	}
	public void setInputModelMap(Map<Integer, InputModel> inputModelMap) {
		this.inputModelMap = inputModelMap;
	}
	public Map<String, TemplateVarVO> getTemplateVarMapForOriginal() {
		return templateVarMapForOriginal;
	}
	public void setTemplateVarMapForOriginal(
			Map<String, TemplateVarVO> templateVarMapForOriginal) {
		this.templateVarMapForOriginal = templateVarMapForOriginal;
	}
	public Map<String, String> getTemplateVarCompileDataMap() {
		return templateVarCompileDataMap;
	}
	public void setTemplateVarCompileDataMap(
			Map<String, String> templateVarCompileDataMap) {
		this.templateVarCompileDataMap = templateVarCompileDataMap;
	}
	public Im getSiteIm() {
		return im;
	}
	public void setSiteIm(Im im) {
		this.im = im;
	}
	@Override
	public String toString() {
		return "UserBean [myAgency=" + myAgency + ", site=" + site
				+ ", parentAgency=" + parentAgency
				+ ", templateVarCompileDataMap=" + templateVarCompileDataMap
				+ ", templateVarMapForOriginal=" + templateVarMapForOriginal
				+ ", siteColumnMap=" + siteColumnMap + ", inputModelMap="
				+ inputModelMap + ", im=" + im + "]";
	}
	
}
