package PaymentGateway.Instrument;

import com.sun.source.tree.LiteralTree;

import java.util.List;

public class InstrumentServiceController {
    InstrumentServiceFactory instrumentServiceFactory;

    InstrumentServiceController(){
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public Instrument addInstrument(Instrument instrument){
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrument.getInstrumentType());
        return instrumentService.addInstrument(instrument);
    }

    List<Instrument> getAllInstruments(int userId){
        InstrumentService instrumentServiceBank = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService instrumentServiceCard = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        List<Instrument> instrumentList = instrumentServiceBank.getInstrumentsByUserId(userId);
        instrumentList.addAll(instrumentServiceCard.getInstrumentsByUserId(userId));
        return instrumentList;
    }
}
