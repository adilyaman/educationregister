package com.example.educationregister.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class ReturnMessages {

    private final Collection<ReturnMessage> errors;

    private final Collection<ReturnMessage> warnings;

    private final Collection<ReturnMessage> infos;

    @JsonCreator
    ReturnMessages(@JsonProperty("errors") Collection<ReturnMessage> errors,
                   @JsonProperty("warnings") Collection<ReturnMessage> warnings,
                   @JsonProperty("infos") Collection<ReturnMessage> infos) {

        this.errors = Collections.unmodifiableCollection(errors);
        this.warnings = Collections.unmodifiableCollection(warnings);
        this.infos = Collections.unmodifiableCollection(infos);
    }

    ReturnMessages(Collection<ReturnMessage> returnMessages) {

        final Collection<ReturnMessage> errorsTmp = Collections.newSetFromMap(new ConcurrentHashMap<ReturnMessage, Boolean>());
        final Collection<ReturnMessage> warningsTmp = Collections.newSetFromMap(new ConcurrentHashMap<ReturnMessage, Boolean>());
        final Collection<ReturnMessage> infosTmp = Collections.newSetFromMap(new ConcurrentHashMap<ReturnMessage, Boolean>());

        for (ReturnMessage returnMessage : returnMessages) {

            switch (returnMessage.severity) {
                case ERROR:
                    errorsTmp.add(returnMessage);
                    break;
                case WARNING:
                    warningsTmp.add(returnMessage);
                    break;
                case INFO:
                    infosTmp.add(returnMessage);
                    break;
            }
        }

        this.errors = Collections.unmodifiableCollection(errorsTmp);
        this.warnings = Collections.unmodifiableCollection(warningsTmp);
        this.infos = Collections.unmodifiableCollection(infosTmp);
    }

}
