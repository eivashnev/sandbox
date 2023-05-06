package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class CrmDetails{
    private ArrayList<CustomerCrm> updated;
    private ArrayList<CustomerCrm> added;
    private ArrayList<CustomerCrm> deleted;
}
