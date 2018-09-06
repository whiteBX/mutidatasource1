package org.white.mutidatasource1.dto;

/**
 * <p>管理员数据实体</p >
 *
 * @author baixiong
 * @version $Id: UserDTO.java, v 0.1 2018年09月05日 16:25:00 baixiong Exp$
 */
public class AdminDTO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 管理员id
     */
    private String adminId;

    /**
     * 管理员名
     */
    private String adminName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
