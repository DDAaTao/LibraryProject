package com.library.libraryproject.entity.Param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomSeatsQueryParam {
    private String seatArea;
    private String seatBuilding;
    private String seatStorey;
    private String seatRoom;
}
