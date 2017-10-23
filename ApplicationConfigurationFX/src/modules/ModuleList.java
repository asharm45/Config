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
public class ModuleList {
    
    private String moduleNo;
    private String moduleName;
    
    public ModuleList(String moduleNo, String moduleName){
        this.moduleNo = moduleNo;
        this.moduleName = moduleName;
    }

    /**
     * @return the moduleNo
     */
    public String getModuleNo() {
        return moduleNo;
    }

    /**
     * @param moduleNo the moduleNo to set
     */
    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    
    
}
