/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author home
 */
public class TestManualList {
    
    private String TestCaseName;
    private String Username;
    private String Password;

    public TestManualList(String TestCaseName, String Username, String Password) {
        this.TestCaseName = TestCaseName;
        this.Username = Username;
        this.Password = Password;
    }

    /**
     * @return the TestCaseName
     */
    public String getTestCaseName() {
        return TestCaseName;
    }

    /**
     * @param TestCaseName the TestCaseName to set
     */
    public void setTestCaseName(String TestCaseName) {
        this.TestCaseName = TestCaseName;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
