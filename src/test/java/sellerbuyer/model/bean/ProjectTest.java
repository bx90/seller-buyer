package sellerbuyer.model.bean;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.*;
import java.util.Date;

/**
 * @author Boxiong
 * @date 3/29/18
 **/
public class ProjectTest {
    private Bid bid1;
    private Bid bid2;

    @BeforeTest
    public void setup() {
        bid1 = new Bid();
        bid2 = new Bid();

    }
    @Test
    public void compareBidPriceDiff() {
        bid1.setPrice(100.0);
        bid2.setPrice(300.0);

//        bid1.setBidDate(LocalDateTime.now());
//        bid2.setBidDate(LocalDateTime.now().minusDays(1));

        Project project = new Project();
        project.addBid(bid1);
        project.addBid(bid2);

        System.out.println(project.getFinalBid());
        Assert.assertEquals(project.getFinalBid().getPrice(), 100.0);
    }

    @Test
    public void samePriceDiffDate() {
        bid1.setPrice(100.0);
        bid2.setPrice(100.0);

//        bid1.setBidDate(LocalDateTime.now().minusDays(1));
//        bid2.setBidDate(LocalDateTime.now());

        Project project = new Project();
        project.addBid(bid1);
        project.addBid(bid2);

        System.out.println(project.getFinalBid());
        Assert.assertEquals(project.getFinalBid().getPrice(), 100.0);
    }

    @Test
    public void timeTest() {
        Date d = new Date();
//        System.out.println(ZoneId.getAvailableZoneIds());
//        System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York")));
//        System.out.println(ZonedDateTime.now());
//        System.out.println(d);
//        System.out.println(d.getTimezoneOffset());
//        ZonedDateTime LAZone= ZonedDateTime.now().atZone(ZoneId.of("America/Los_Angeles"))Los_Angeles;
        // useful
//        Instant instant = Instant.now();
//        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println(instant);
//
//        ZonedDateTime zdt = instant.atZone(zoneId);
//        ZonedDateTime zdt2 = instant.atZone(ZoneId.of("America/New_York"));
//
//        System.out.println(zdt.isEqual(zdt2));


        System.out.println(ZonedDateTime.now());
//        LocalDateTime ldt = LocalDateTime.parse("2018-01-21T15:00");
        LocalDateTime ldt = LocalDateTime.parse("2018-01-21T15:00");
        System.out.println(ldt);
        System.out.println(ldt.atZone(ZoneId.systemDefault()));
//        ZonedDateTime zdt = ldt.atZone(ZoneId.systemDefault());
//        ZonedDateTime zdt2 = ldt.atZone(ZoneId.of("America/New_York"));
//        System.out.println(zdt);
//        System.out.println(zdt2);
//        Instant instant = ld.at

        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant);

        System.out.println(instant.atZone(ZoneId.systemDefault()));
        System.out.println(instant.atZone(ZoneId.of("America/New_York")));


    }
}
