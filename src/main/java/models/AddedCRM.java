package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddedCRM{
    private String crmName;
    private String crmId;
    private Boolean allowedToUse;
}