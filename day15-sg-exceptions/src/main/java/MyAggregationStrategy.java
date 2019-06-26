 import java.util.List;
 import java.util.Map;
 
 import org.apache.log4j.Logger;
 import org.mule.api.MuleContext;
 import org.mule.api.MuleEvent;
 import org.mule.api.MuleException;
 import org.mule.api.context.MuleContextAware;
 import org.mule.api.routing.AggregationContext;
 import org.mule.api.routing.RouterResultsHandler;
 import org.mule.routing.AggregationStrategy;
 import org.mule.routing.DefaultRouterResultsHandler;
 
 public class MyAggregationStrategy implements AggregationStrategy, MuleContextAware {
     
     private static final Logger logger = Logger.getLogger(MyAggregationStrategy.class);
     
     private RouterResultsHandler resultsHandler = new DefaultRouterResultsHandler();
     private MuleContext muleContext;
     
     @Override
     public MuleEvent aggregate(AggregationContext context) throws MuleException {
         //MuleEvent event = aggregate(context);
         List<MuleEvent> eventsWithExceptions = context.collectEventsWithExceptions();
         List<MuleEvent> eventsWithoutExceptions = context.collectEventsWithoutExceptions();
         
         if (!eventsWithExceptions.isEmpty()) {
             logger.warn(String.format("Found %d exceptions in total. Continuing with whatever has been collected so far.", eventsWithExceptions.size()));
             
             logger.debug("Logging exceptions for individual paths. Route indexes are zero-based.");
             for (Map.Entry<Integer, Throwable> routeException : context.collectRouteExceptions().entrySet()) {
                 logger.debug(String.format("An exception was found for route %d: ", routeException.getKey()), routeException.getValue());

                
                 
                 /*Throwable Result = routeException.getValue().getCause();
                 String FinalResult = Result.toString();*/
                 
                 System.out.println("An exception was found for route %d: " + routeException.getValue());
                
                 
                 
             }
         }
         
         
         return resultsHandler.aggregateResults(eventsWithoutExceptions, context.getOriginalEvent(), muleContext);
         
     }
 
     @Override
     public void setMuleContext(MuleContext context) {
         this.muleContext = context;
     }
     
 }