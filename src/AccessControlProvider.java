import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccessControlProvider {
    public static void main(String[] args) {
        Provider[] availableProviders;
        availableProviders = Security.getProviders();
        for (Provider p: availableProviders ) {
            Set<Provider.Service> services = p.getServices();
            List<String> algoritmesDeTipusMessageDigest = services.stream()
                    .filter(s -> s.getType().equals(MessageDigest.class.getSimpleName()))
                    .map(s -> s.getAlgorithm())
                    .sorted()
                    .collect(Collectors.toList());
            if (!algoritmesDeTipusMessageDigest.isEmpty()){
                System.out.println(algoritmesDeTipusMessageDigest);

            }
        }
    }
}