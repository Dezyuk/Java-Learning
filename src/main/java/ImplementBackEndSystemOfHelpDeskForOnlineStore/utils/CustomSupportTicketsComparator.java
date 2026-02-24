package ImplementBackEndSystemOfHelpDeskForOnlineStore.utils;

import ImplementBackEndSystemOfHelpDeskForOnlineStore.enteties.SupportTicket;

import java.util.Comparator;

public class CustomSupportTicketsComparator implements Comparator<SupportTicket> {
    @Override
    public int compare(SupportTicket o1, SupportTicket o2) {
        if (o1 == null || o2 == null || o1.getPriority() == null || o2.getPriority() == null) {
            return 0;
        }

        int result = o2.getPriority().compareTo(o1.getPriority());
        if (result == 0) {
            result = o1.getSequentialNumber() - o2.getSequentialNumber();
        }
        return result;
    }
}
