package pl.bd.aquapark.dto;

public class VisitDto {
    private Long userId;
    private Long identificatorId;

    public VisitDto(Long userId, Long identificatorId) {
        this.userId = userId;
        this.identificatorId = identificatorId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getIdentificatorId() {
        return this.identificatorId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setIdentificatorId(Long identificatorId) {
        this.identificatorId = identificatorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof VisitDto)) return false;
        final VisitDto other = (VisitDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$identificatorId = this.getIdentificatorId();
        final Object other$identificatorId = other.getIdentificatorId();
        if (this$identificatorId == null ? other$identificatorId != null : !this$identificatorId.equals(other$identificatorId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof VisitDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $identificatorId = this.getIdentificatorId();
        result = result * PRIME + ($identificatorId == null ? 43 : $identificatorId.hashCode());
        return result;
    }

    public String toString() {
        return "VisitDto(userId=" + this.getUserId() + ", identificatorId=" + this.getIdentificatorId() + ")";
    }
}
