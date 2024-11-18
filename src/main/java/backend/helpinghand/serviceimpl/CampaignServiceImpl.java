package backend.helpinghand.serviceimpl;

import backend.helpinghand.dtos.DTOCampaignSummary;
import backend.helpinghand.entities.Campaign;
import backend.helpinghand.entities.Donation;
import backend.helpinghand.entities.Profile;
import backend.helpinghand.exceptions.InvalidDataException;
import backend.helpinghand.exceptions.ResourceNotFoundException;
import backend.helpinghand.repositories.CampaignRepository;
import backend.helpinghand.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    CampaignRepository campaignRepository;


    @Override
    public Campaign findCampById(Long id) throws ResourceNotFoundException {
        Campaign campaignFound = campaignRepository.findById(id).orElse(null);
        return campaignFound;
    }

    @Override
    public List<Campaign> listAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign addCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public List<DTOCampaignSummary> listAllDTOCampaigns() {
        List<DTOCampaignSummary> dtoCampaignSummaries = new ArrayList<>();

        List<Campaign> campaigns = listAllCampaigns();
        for (Campaign campaign : campaigns) {
            Long campaignId = campaign.getId();
            String campaignName = campaign.getCampaignName();
            Double moneyGoal = campaign.getMoneyGoal();
            Double moneyRaised = 0.0;
            String startDate = campaign.getStartDate();
            String endDate = campaign.getEndDate();

            for(Donation donation: campaign.getDonations()){
                moneyRaised = moneyRaised + donation.getMoney_amount().doubleValue();
            }
            Double percentage = (moneyRaised/moneyGoal)*100.0;
            DTOCampaignSummary dtoCampaignSummary = new DTOCampaignSummary(campaignId,campaignName,moneyGoal,moneyRaised,percentage,startDate,endDate);
            dtoCampaignSummaries.add(dtoCampaignSummary);
        }
        return dtoCampaignSummaries;
    }

    @Override
    public void deleteCampaign(Long id) {
        Campaign campaignFound = findCampById(id);
        if (campaignFound == null) {
            throw new ResourceNotFoundException("Campaign with id: "+id+" not found");
        }
        campaignRepository.delete(campaignFound);
    }

    @Override
    public List<Campaign> getCampaignsByName(String campaignName) {
        return campaignRepository.findByCampaignNameContains(campaignName);
    }

    @Override
    public List<Campaign> getCampaignsByOrganization(Long organizationId) {
        return campaignRepository.findByOrganization_Id(organizationId);
    }


    @Override
    public List<Campaign> getCampaignsByCategory(Long categoryId) {
        return campaignRepository.findByCategory_Id(categoryId);
    }

    @Override
    public List<Campaign> getCampaignsByMoneyGoalGreaterThan(Double moneyGoal) {
        return campaignRepository.findByMoneyGoalGreaterThan(moneyGoal);
    }


}
