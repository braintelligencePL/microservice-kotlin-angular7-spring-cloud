package pl.braintelligence.projectmanager.domain.exceptions

enum class ErrorCode {

    TEAM_ALREADY_EXISTS,
    EMPTY_TEAM_NAME,
    NONEXISTENT_TEAM,
    EMPTY_MEMBER,
    EMPTY_MEMBER_FIRST_NAME,
    EMPTY_MEMBER_LAST_NAME,
    EMPTY_MEMBER_JOB_POSITION,
    INVALID_MEMBER_JOB_POSITION,
}