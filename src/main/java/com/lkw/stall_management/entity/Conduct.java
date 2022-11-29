package com.lkw.stall_management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName conduct
 */
@TableName(value ="conduct")
@Data
public class Conduct implements Serializable {
    /**
     * 证件id
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 证据照片1
     */
    private String evidenceUrl1;

    /**
     * 证据照片2
     */
    private String evidenceUrl2;

    /**
     * 证据照片3
     */
    private String evidenceUrl3;

    /**
     * 地摊id
     */
    private String stallId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 管理者id
     */
    private String managerId;

    /**
     * 状态:1是正在审判,2是审判成功,3是证据不足审判失败
     */
    private Integer state;

    /**
     * 逻辑删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Conduct other = (Conduct) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getEvidenceUrl1() == null ? other.getEvidenceUrl1() == null : this.getEvidenceUrl1().equals(other.getEvidenceUrl1()))
            && (this.getEvidenceUrl2() == null ? other.getEvidenceUrl2() == null : this.getEvidenceUrl2().equals(other.getEvidenceUrl2()))
            && (this.getEvidenceUrl3() == null ? other.getEvidenceUrl3() == null : this.getEvidenceUrl3().equals(other.getEvidenceUrl3()))
            && (this.getStallId() == null ? other.getStallId() == null : this.getStallId().equals(other.getStallId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getManagerId() == null ? other.getManagerId() == null : this.getManagerId().equals(other.getManagerId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getEvidenceUrl1() == null) ? 0 : getEvidenceUrl1().hashCode());
        result = prime * result + ((getEvidenceUrl2() == null) ? 0 : getEvidenceUrl2().hashCode());
        result = prime * result + ((getEvidenceUrl3() == null) ? 0 : getEvidenceUrl3().hashCode());
        result = prime * result + ((getStallId() == null) ? 0 : getStallId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getManagerId() == null) ? 0 : getManagerId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", evidenceUrl1=").append(evidenceUrl1);
        sb.append(", evidenceUrl2=").append(evidenceUrl2);
        sb.append(", evidenceUrl3=").append(evidenceUrl3);
        sb.append(", stallId=").append(stallId);
        sb.append(", userId=").append(userId);
        sb.append(", managerId=").append(managerId);
        sb.append(", state=").append(state);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}