package backend.helpinghand.repositories;

import backend.helpinghand.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findByCampaignNameContains(String campaignName);
    List<Campaign> findByOrganization_Id(Long organizationId);
    List<Campaign> findByCategory_Id(Long categoryId);
    List<Campaign> findByMoneyGoalGreaterThan(Double moneyGoal);

}

