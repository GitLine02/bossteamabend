package de.tensing.bossteam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static de.tensing.bossteam.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index**", "/error**", "/css/*", "/js/*", "/img/*").permitAll()
                .antMatchers("/player/1").hasAnyRole(P1.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/2").hasAnyRole(P2.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/3").hasAnyRole(P3.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/4").hasAnyRole(P4.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/5").hasAnyRole(P5.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/6").hasAnyRole(P6.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/7").hasAnyRole(P7.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/8").hasAnyRole(P8.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/9").hasAnyRole(P9.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/10").hasAnyRole(P10.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/11").hasAnyRole(P11.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/12").hasAnyRole(P12.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/13").hasAnyRole(P13.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/14").hasAnyRole(P14.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/15").hasAnyRole(P15.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/16").hasAnyRole(P16.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/17").hasAnyRole(P17.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/18").hasAnyRole(P18.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/19").hasAnyRole(P19.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/20").hasAnyRole(P20.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/21").hasAnyRole(P21.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/22").hasAnyRole(P22.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/23").hasAnyRole(P23.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/24").hasAnyRole(P24.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/25").hasAnyRole(P25.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/26").hasAnyRole(P26.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/27").hasAnyRole(P27.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/28").hasAnyRole(P28.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/29").hasAnyRole(P29.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/30").hasAnyRole(P30.name(), BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/player/**").hasAnyRole(BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/game/progress/**").hasAnyRole(BOSSTEAMER.name(), ADMIN.name())
                .antMatchers("/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/error403.html")
                .and()
                .httpBasic();
    }

    private UserDetails createNewUser(String username, String password, ApplicationUserRole role) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(role.name())
                .build();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails bossTeamUser = createNewUser("bossteam", "bittekeinbit3", BOSSTEAMER);
        UserDetails jannismfUser = createNewUser("jannismf", "s0nnenschule", ADMIN);
        UserDetails p1User = createNewUser("p1", "rennen", P1);
        UserDetails p2User = createNewUser("p2", "laib", P2);
        UserDetails p3User = createNewUser("p3", "abendessen", P3);
        UserDetails p4User = createNewUser("p4", "schuppen", P4);
        UserDetails p5User = createNewUser("p5", "lippe", P5);
        UserDetails p6User = createNewUser("p6", "eidechsen", P6);
        UserDetails p7User = createNewUser("p7", "schiff", P7);
        UserDetails p8User = createNewUser("p8", "alarm", P8);
        UserDetails p9User = createNewUser("p9", "vorschlag", P9);
        UserDetails p10User = createNewUser("p10", "ekel", P10);
        UserDetails p11User = createNewUser("p11", "handel", P11);
        UserDetails p12User = createNewUser("p12", "streichholz", P12);
        UserDetails p13User = createNewUser("p13", "meisterschaft", P13);
        UserDetails p14User = createNewUser("p14", "pferde", P14);
        UserDetails p15User = createNewUser("p15", "stretch", P15);
        UserDetails p16User = createNewUser("p16", "paket", P16);
        UserDetails p17User = createNewUser("p17", "vers", P17);
        UserDetails p18User = createNewUser("p18", "kohl", P18);
        UserDetails p19User = createNewUser("p19", "steuer", P19);
        UserDetails p20User = createNewUser("p20", "ehe", P20);
        UserDetails p21User = createNewUser("p21", "termin", P21);
        UserDetails p22User = createNewUser("p22", "menge", P22);
        UserDetails p23User = createNewUser("p23", "eimer", P23);
        UserDetails p24User = createNewUser("p24", "hammer", P24);
        UserDetails p25User = createNewUser("p25", "knie", P25);
        UserDetails p26User = createNewUser("p26", "wurzel", P26);
        UserDetails p27User = createNewUser("p27", "bewegung", P27);
        UserDetails p28User = createNewUser("p28", "sprache", P28);
        UserDetails p29User = createNewUser("p29", "tante", P29);
        UserDetails p30User = createNewUser("p30", "wissenschaft", P30);

        return new InMemoryUserDetailsManager(
                bossTeamUser,
                jannismfUser,
                p1User,
                p2User,
                p3User,
                p4User,
                p5User,
                p6User,
                p7User,
                p8User,
                p9User,
                p10User,
                p11User,
                p12User,
                p13User,
                p14User,
                p15User,
                p16User,
                p17User,
                p18User,
                p19User,
                p20User,
                p21User,
                p22User,
                p23User,
                p24User,
                p25User,
                p26User,
                p27User,
                p28User,
                p29User,
                p30User
        );
    }
}
