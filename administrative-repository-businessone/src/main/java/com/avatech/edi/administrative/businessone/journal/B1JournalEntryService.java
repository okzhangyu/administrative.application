package com.avatech.edi.administrative.businessone.journal;

import com.avatech.edi.administrative.model.bo.B1Connection;
import com.avatech.edi.administrative.model.bo.IVoucher;

public interface B1JournalEntryService {

    String createJournalEntry(IVoucher voucher, B1Connection connection);
}
