package com.ld.codeGenerate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the t145 database table.
 * 
 */
@Entity
@Table(name = "t145")
public class MemberArticle implements Serializable {

	/**
	 * serial No
	 */
	private static final long serialVersionUID = 3098326858653427003L;
	// article id
	private Long articleId;
	private Date createDateTime;
	private String createUserId;
	private Date updateDateTime;
	private String updateUserId;
	private Boolean delFlag;
	// article no
	private String articleNo;
	// article name
	private String articleName;
	// article quantity
	private Integer articleQuantity;
	// quantity unit
	private String quantityUnit;
	// corresponding points
	private Integer point;

	public MemberArticle() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "V400301", unique = true, nullable = false)
	public Long getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "C999991", nullable = false)
	public Date getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	@Column(name = "C999992", nullable = false, length = 8)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "C999993", nullable = false)
	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Column(name = "C999994", nullable = false, length = 8)
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Column(name = "C999995", nullable = false)
	public Boolean getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	@Column(name = "V400302", nullable = false, length = 8)
	public String getArticleNo() {
		return this.articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	@Column(name = "V400303", nullable = false, length = 32)
	public String getArticleName() {
		return this.articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	@Column(name = "V400304", nullable = false)
	public Integer getArticleQuantity() {
		return this.articleQuantity;
	}

	public void setArticleQuantity(Integer articleQuantity) {
		this.articleQuantity = articleQuantity;
	}

	@Column(name = "V400305", length = 6)
	public String getQuantityUnit() {
		return this.quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	@Column(name = "V400306", nullable = false)
	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}


}