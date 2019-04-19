package edu.uel.proteo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.format.annotation.DateTimeFormat;

public abstract class Record {

	@Id
	private Long id;
	
	@Version
	private Long version;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date createDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date updateDate;
	
	private Boolean active;
	
	public Record() {}

	public Record(Long id, Long version, Date createDate, Date updateDate, Boolean active) {
		this.id = id;
		this.version = version;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
