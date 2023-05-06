/*
 * Copyright Avaya Inc., All Rights Reserved. THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Avaya Inc. The copyright
 * notice above does not evidence any actual or intended publication of such source code. Some third-party source code
 * components may have been modified from their original versions by Avaya Inc. The modifications are Copyright Avaya
 * Inc., All Rights Reserved. Avaya - Confidential & Restricted. May not be distributed further without written
 * permission of the Avaya owner.
 */
package models;

/**
 * @author daly27
 */
public class CustomerCrm {

    private String crmId;
    private String crmName;
    private String crmType;
    private boolean defaultCrm;
    private boolean allowedToUse;

    public CustomerCrm() {
        // Empty constructor for JSON decoding
    }

    public String getCrmId() {
        return crmId;
    }

    public void setCrmId(String crmId) {
        this.crmId = crmId;
    }

    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    public String getCrmType() {
        return crmType;
    }

    public void setCrmType(String crmType) {
        this.crmType = crmType;
    }

    public boolean isDefaultCrm() {
        return defaultCrm;
    }

    public void setDefaultCrm(boolean defaultCrm) {
        this.defaultCrm = defaultCrm;
    }

    public boolean isAllowedToUse() {
        return allowedToUse;
    }

    public void setAllowedToUse(boolean allowedToUse) {
        this.allowedToUse = allowedToUse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CustomerCrm [crmId=");
        builder.append(crmId);
        builder.append(", crmName=");
        builder.append(crmName);
        builder.append(", crmType=");
        builder.append(crmType);
        builder.append(", defaultCrm=");
        builder.append(defaultCrm);
        builder.append(", allowedToUse=");
        builder.append(allowedToUse);
        builder.append("]");
        return builder.toString();
    }

}
