package pl.bd.aquapark.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.bd.aquapark.dao.ClientIdentificator;
import pl.bd.aquapark.repository.IdentificatorRepository;

import java.util.List;

public class IdentificatorService {

    public static ClientIdentificator findFreeIdentificator(IdentificatorRepository identificatorRepository) {
        List<ClientIdentificator> clientIdentificators = GetAllService.getAll(identificatorRepository);

        for (ClientIdentificator clientIdentificator : clientIdentificators) {
            if (!clientIdentificator.getIsInUse()) {
                return clientIdentificator;
            }
        }

        return null;

    }


}
