package Spotpack.event;

import java.util.ArrayList;
import java.util.Iterator;

public class Event {
   public Event call() {
      ArrayList<EventData> dataList = EventManager.get(this.getClass());
      if (dataList != null) {
         Iterator var3 = dataList.iterator();

         while(var3.hasNext()) {
            EventData data = (EventData)var3.next();

            try {
               data.target.invoke(data.source, this);
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      }

      return this;
   }
}
