package PaymentGateway.Instrument;

import java.util.ArrayList;
import java.util.List;

public class BankInstrumentService extends InstrumentService{
    @Override
    public Instrument addInstrument(Instrument instrument) {
        List<Instrument> getList = userVsInstruments.get(instrument.getInstrumentId());
        if(getList == null){
            getList = new ArrayList<>();
        }
        getList.add(instrument);
        userVsInstruments.put(instrument.getUserId(), getList);
        return instrument;
    }

    @Override
    public List<Instrument> getInstrumentsByUserId(int userId) {
        return userVsInstruments.get(userId);
    }
}
