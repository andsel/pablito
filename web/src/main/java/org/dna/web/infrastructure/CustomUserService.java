package org.dna.web.infrastructure;

import org.dna.model.BidderRepository;
import org.dna.model.TaskBidder;
import org.dna.model.Tasker;
import org.dna.model.TaskerRepository;
import org.dna.web.model.CustomUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;

/**
 * Customized DB access service to UserDetails
 *
 * Created by andrea on 25/08/16.
 */
public class CustomUserService implements UserDetailsService {

    private TaskerRepository taskerRepo;
    private BidderRepository bidderRepo;

    public CustomUserService(TaskerRepository taskerRepo, BidderRepository bidderRepo) {
        this.taskerRepo = taskerRepo;
        this.bidderRepo = bidderRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.startsWith("requester") && !username.startsWith("tasker")) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }

        String authority = "";
        long id = -1;
        if (username.startsWith("tasker")) {
            id = Long.parseLong(username.split("tasker")[1]);
            Tasker tasker = this.taskerRepo.getByID(id);
            if (tasker == null) {
                throw new UsernameNotFoundException("User '" + username + "' not found.");
            }
            authority = "ROLE_TASKER";
        }
        if (username.startsWith("requester")) {
            id = Long.parseLong(username.split("requester")[1]);
            TaskBidder bidder = this.bidderRepo.getByID(id);
            if (bidder == null) {
                throw new UsernameNotFoundException("User '" + username + "' not found.");
            }
            authority = "ROLE_REQUESTER";
        }

        if (StringUtils.isEmpty(authority)) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        return new CustomUser(id, username, "pwd", asList(new SimpleGrantedAuthority(authority)));
    }
}
