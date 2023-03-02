package com.dxjunkyard.sportsevent.domain.response;

import com.dxjunkyard.sportsevent.domain.Participant;
import lombok.Data;

import java.util.List;

@Data
public class GetParticipantsResponse {
    private List<Participant> participantList;
}
