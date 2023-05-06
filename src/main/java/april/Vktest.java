package april;

import models.AbstractClass;
import models.ChildClass;

import javax.mail.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Vktest {
    public static int test() {
        try {
            throw new Exception("asda");
        } catch (Exception e) {
            System.out.println("blat");
            return 10;
        } finally {
            return 20;
        }
    }

    public static void main(String[] args) {

        String[] strings = new String[] {"ab", "cd", "ef"};
        List<String> stringList = new ArrayList<>();
        stringList.add("ab");
        strings = (String[]) Arrays.stream(strings).filter(s -> !stringList.contains(s)).toArray(String[]::new);
        System.out.println(Arrays.deepToString(strings));

        String content = "abcde";
        System.out.println(content.length() + " " + content.substring(0, 5));

        List<String> sl = new ArrayList<>();
        sl.add("asdasd");
        sl.add("vcxvv");
        sl.add("iou");

        String[] as = sl.toArray(new String[0]);
        for (String a : as) {
            System.out.println(a);
        }


        String warn = String.format("There are [%d] undeleted messages in Folder: [%s]",5, "this.getFolder().getURLName()");
        System.out.println(warn);

        AbstractClass childClass = new ChildClass();

        childClass.echo();


        System.out.println(test());

        LinkedList<String> s = new LinkedList<>();


        String s2;




        //int i;
/*        int[] m = new int[10];
        System.out.println(m[0]);
        String users = "706645446,706754569,706769506,707260459,707306346,707347786,707486307,707686857,707886041,708023689,708507104,709064281,709871930,710178664,710179006,710314568,710370804,710377285,710437271,711130599,711149311,711149430,711206459,711446344,711659511,711869298,711901765,712371570,712382571,712886023,713080489,713161050,713283890,713389390,713676059,714150929,714300874,714477011,714995214,715205813,715345215,715528107,715555527,715729266,715793880,716157620,716219212,716824893,716896351,717053715,717261657,717320010,717795178,718192825,719138401,719247831,719723823,719775213,719866008,719983047,720493395,720563732,720836629,720863940,721146724,721271263,721602209,722169759,722697999,722706934,722725917,723006563,723493701,728473726,728698076,728844346,728870850,729152358,729913472,729975155,730088107,730168640,730257170,730881320,730909490,731237473,731445021,732329372,732390641,732400975,732430599,732515425,732526418,732814801,733033758,733358553,733455470,733674604,733937077,734026843,734435349,734705135,734878210,734919555,735114285,735277398,735358696,735444406,735801037,736217015,736247528,737069853,737756304,737900285,738295491,738477094,738593744,738676222,738689686,738732394,738782906,738936740,739201123,739507544,740534579,741061284,741350352,741715639,741826728,741939804,742203669,742293106,743094406,743095887,743097620,743598270,743709135,744180306,744235557,744380100,744746384,745062601,745178657,745388128,745561165,745582675,745753508,746051763,746228687,746251639,746471935,747368130,748183890,748383963,748933479,748969454,749625211,749644945,749747170,750079415,750359131,751002534,751316927,751850312,753519652,753818200,753913450,754678743,754920388,754947606,755142024,755576276,755891310,756076506,756480676,756502943,757035940,757414846,758191564,758661901,759309943,760572970,760591593,760943982,761175606,761420823,761935571,762552760,762780867,763602274,764359904,765439359,765649705,765655556,766540045,766834618";

        Set<Integer> set = new HashSet<>();
        System.out.println(set.contains(2));
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(1);
        System.out.println(set);

        String[] list = users.split(",");
        int n = 0;
        int f = 0;
        for (String id : list) {
            if (id.startsWith("7") && id.length() == 9) n++;
            if (id.startsWith("5") && id.length() == 9) {
                f++;
                System.out.println("<a href=\"https://vk.com/id"+id+"\">id"+id+"</a>");
            }
            System.out.println("<a href=\"https://vk.com/id"+id+"\">id"+id+"</a>");
        }
        System.out.println(f);
        System.out.println(n);
        System.out.println(list.length);*/
    }

}
