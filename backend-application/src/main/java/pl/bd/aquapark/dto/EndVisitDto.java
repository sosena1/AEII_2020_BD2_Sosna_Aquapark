package pl.bd.aquapark.dto;

public class EndVisitDto {
    private Long identificatorId;

    public EndVisitDto(Long identificatorId) {
        this.identificatorId = identificatorId;
    }

    public EndVisitDto() {
    }

    public Long getIdentificatorId() {
        return this.identificatorId;
    }

    public void setIdentificatorId(Long identificatorId) {
        this.identificatorId = identificatorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EndVisitDto)) return false;
        final EndVisitDto other = (EndVisitDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$identificatorId = this.getIdentificatorId();
        final Object other$identificatorId = other.getIdentificatorId();
        if (this$identificatorId == null ? other$identificatorId != null : !this$identificatorId.equals(other$identificatorId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EndVisitDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $identificatorId = this.getIdentificatorId();
        result = result * PRIME + ($identificatorId == null ? 43 : $identificatorId.hashCode());
        return result;
    }

    public String toString() {
        return "EndVisitDto(identificatorId=" + this.getIdentificatorId() + ")";
    }
}
