package ru.zgys.demo.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

/**
 * @author U.Goryntsev 29.08.2017
 */
@MappedSuperclass
public class BaseEntity {
	private boolean active;

	@Column(name = "create_date")
	private LocalDateTime creationDate;

	@Column(name = "last_update")
	private LocalDateTime lastUpdateDate;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@PrePersist
	protected void onCreate() {
		LocalDateTime time = now();
		this.setCreationDate(time);
		this.setLastUpdateDate(time);
		this.setActive(true);
	}

	@PreUpdate
	protected void onUpdate() {
		this.setLastUpdateDate(now());
	}
}
