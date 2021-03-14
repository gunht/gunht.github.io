package java_project.entity;

public class User extends AbstractId {
    private String username;
    private String fullName;
    private String password;
    private int status;
    private Long roleId;
    private Role role;

    public User() {

    }

    public User(String username, String password, String fullName, int status, Long roleId) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getId() +
                ". Username: " + getUsername() +
                ", full_name: " + getFullName() +
                ", role: " + getRole().getName() +
                ", status: " + getStatus();
    }
}
