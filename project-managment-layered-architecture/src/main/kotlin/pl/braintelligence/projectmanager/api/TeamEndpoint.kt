package pl.braintelligence.projectmanager.api

import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.application.team.dto.NewTeamDto
import pl.braintelligence.projectmanager.application.team.TeamService
import pl.braintelligence.projectmanager.application.team.dto.ExistingTeamDto
import pl.braintelligence.projectmanager.application.team.dto.TeamMemberDto

@RestController
@RequestMapping(value = ["/teams"])
class TeamEndpoint(
        val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun createTeam(@RequestBody newTeamDto: NewTeamDto) {
        teamService.createTeam(newTeamDto)
    }

    @PostMapping("{teamName}/members")
    @ResponseStatus(CREATED)
    fun addMemberToTeam(@PathVariable teamName: String, @RequestBody teamMemberDto: TeamMemberDto) {
        teamService.addMemberToTeam()
    }

    @GetMapping
    @ResponseStatus(OK)
    fun getTeams(): List<ExistingTeamDto> {
        return teamService.getTeams()
    }
}
