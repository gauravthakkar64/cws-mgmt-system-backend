package com.cwsms.model.issue.type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cwsms.constants.SpringConstants;
import com.cwsms.model.issue.Issue;

@Entity
@Table(name=SpringConstants.TABLE_ISSUE_TYPE)
public class IssueType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=SpringConstants.GENERATOR_ISSUE_TYPE)
	@SequenceGenerator(name=SpringConstants.GENERATOR_ISSUE_TYPE, sequenceName=SpringConstants.SEQUENCE_ISSUE_TYPE)
	@Column(name=SpringConstants.ISSUE_TYPE_ID)
	private Long id;
	
	@Column(name=SpringConstants.ISSUE_TYPE_NAME, length=30, nullable=false)
	private String issueTypeName;
	
	@Column(name=SpringConstants.ISSUE_TYPE_PRIORITY, length=30, nullable=false)
	private String issueTypePriority;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy=SpringConstants.ISSUE_FK)
	private Issue issue;
	
	public IssueType(String issueTypeName, String issueTypePriority) {
		super();
		this.issueTypeName = issueTypeName;
		this.issueTypePriority = issueTypePriority;
	}
	public IssueType() {
		super();
	}
	public String getIssueTypeName() {
		return issueTypeName;
	}
	public void setIssueTypeName(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}
	public String getIssueTypePriority() {
		return issueTypePriority;
	}
	public void setIssueTypePriority(String issueTypePriority) {
		this.issueTypePriority = issueTypePriority;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
