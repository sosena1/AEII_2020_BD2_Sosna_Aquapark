package pl.bd.aquapark.util;

import pl.bd.aquapark.dao.ClientIdentificator;
import pl.bd.aquapark.repository.IdentificatorRepository;

import java.util.List;

public class IdentificatorUtil {

    public static ClientIdentificator findFreeIdentificator(IdentificatorRepository identificatorRepository) {
        List<ClientIdentificator> clientIdentificators = GetAllUtil.getAll(identificatorRepository);

        for (ClientIdentificator clientIdentificator : clientIdentificators) {
            if (!clientIdentificator.getIsInUse()) {
                return clientIdentificator;
            }
        }

        return null;

    }


}
