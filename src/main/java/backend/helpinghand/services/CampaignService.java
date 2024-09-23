package backend.helpinghand.services;

import backend.helpinghand.entities.Campaign;

import java.util.List;

public interface CampaignService {
    public List<Campaign> listAllCampaigns();
    public Campaign addCampaign(DTOCampaign dtoCampaign);
}
