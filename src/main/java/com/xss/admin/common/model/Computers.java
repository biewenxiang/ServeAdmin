package com.xss.admin.common.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 服务器表
 */
@Alias("computers")
public class Computers implements Serializable {

	private Integer id;//id

	private String name;//服务器名称

	private String ip;//服务器ip

	private String computertype;//服务器类型、虚拟物理

	private String businessos;//业务系统

	private String computeros;//服务器系统

	private String computerpwd;//系统密码

	private String dbtype;//数据库类型

	private String dbpwd;//数据库密码

	private String yinyongpwd;//应用密码

	private String computetype;//状况：打开电源与关闭电源

	private String computerip;//主机

	private String computerrom;//置备空间

	private String comment;//备注

	private String vpnuname;//vpn访问账号

	private String mainprogram;//主要程序

	private String ospatch;//系统补丁

	private String dbbackup;//数据备份情况

	private String Serveradmin;//服务器管理人员

	private String computeropenport;//服务开放端口

	private String antivirus;//杀毒软件

	private String networkmanage;//网管监控

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getComputertype() {
		return computertype;
	}

	public void setComputertype(String computertype) {
		this.computertype = computertype;
	}

	public String getBusinessos() {
		return businessos;
	}

	public void setBusinessos(String businessos) {
		this.businessos = businessos;
	}

	public String getComputeros() {
		return computeros;
	}

	public void setComputeros(String computeros) {
		this.computeros = computeros;
	}

	public String getComputerpwd() {
		return computerpwd;
	}

	public void setComputerpwd(String computerpwd) {
		this.computerpwd = computerpwd;
	}

	public String getDbtype() {
		return dbtype;
	}

	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getDbpwd() {
		return dbpwd;
	}

	public void setDbpwd(String dbpwd) {
		this.dbpwd = dbpwd;
	}

	public String getYinyongpwd() {
		return yinyongpwd;
	}

	public void setYinyongpwd(String yinyongpwd) {
		this.yinyongpwd = yinyongpwd;
	}

	public String getComputetype() {
		return computetype;
	}

	public void setComputetype(String computetype) {
		this.computetype = computetype;
	}

	public String getComputerip() {
		return computerip;
	}

	public void setComputerip(String computerip) {
		this.computerip = computerip;
	}

	public String getComputerrom() {
		return computerrom;
	}

	public void setComputerrom(String computerrom) {
		this.computerrom = computerrom;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getVpnuname() {
		return vpnuname;
	}

	public void setVpnuname(String vpnuname) {
		this.vpnuname = vpnuname;
	}

	public String getMainprogram() {
		return mainprogram;
	}

	public void setMainprogram(String mainprogram) {
		this.mainprogram = mainprogram;
	}

	public String getOspatch() {
		return ospatch;
	}

	public void setOspatch(String ospatch) {
		this.ospatch = ospatch;
	}

	public String getDbbackup() {
		return dbbackup;
	}

	public void setDbbackup(String dbbackup) {
		this.dbbackup = dbbackup;
	}

	public String getServeradmin() {
		return Serveradmin;
	}

	public void setServeradmin(String Serveradmin) {
		this.Serveradmin = Serveradmin;
	}

	public String getComputeropenport() {
		return computeropenport;
	}

	public void setComputeropenport(String computeropenport) {
		this.computeropenport = computeropenport;
	}

	public String getAntivirus() {
		return antivirus;
	}

	public void setAntivirus(String antivirus) {
		this.antivirus = antivirus;
	}

	public String getNetworkmanage() {
		return networkmanage;
	}

	public void setNetworkmanage(String networkmanage) {
		this.networkmanage = networkmanage;
	}

}