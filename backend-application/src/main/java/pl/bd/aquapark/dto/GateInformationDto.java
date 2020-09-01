package pl.bd.aquapark.dto;

public class GateInformationDto {
    private Long gateId;
    private Long identificatorId;

    public GateInformationDto() {
    }

    public Long getGateId() {
        return this.gateId;
    }

    public Long getIdentificatorId() {
        return this.identificatorId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public void setIdentificatorId(Long identificatorId) {
        this.identificatorId = identificatorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GateInformationDto)) return false;
        final GateInformationDto other = (GateInformationDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$gateId = this.getGateId();
        final Object other$gateId = other.getGateId();
        if (this$gateId == null ? other$gateId != null : !this$gateId.equals(other$gateId)) return false;
        final Object this$identificatorId = this.getIdentificatorId();
        final Object other$identificatorId = other.getIdentificatorId();
        if (this$identificatorId == null ? other$identificatorId != null : !this$identificatorId.equals(other$identificatorId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GateInformationDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $gateId = this.getGateId();
        result = result * PRIME + ($gateId == null ? 43 : $gateId.hashCode());
        final Object $identificatorId = this.getIdentificatorId();
        result = result * PRIME + ($identificatorId == null ? 43 : $identificatorId.hashCode());
        return result;
    }

    public String toString() {
        return "GateInformationDto(gateId=" + this.getGateId() + ", identificatorId=" + this.getIdentificatorId() + ")";
    }
}
