package pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.braintelligence.projectmanager.core.projects.domain.Project
import pl.braintelligence.projectmanager.core.projects.ports.incoming.ProjectCreatorPort
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectDraft
import pl.braintelligence.projectmanager.infrastructure.adapter.incoming.rest.dto.ProjectWithFeatures

/**
 * Primary Adapter
 */

@RestController
@RequestMapping("/projects")
internal class ProjectController(
        private val projectCreatorPort: ProjectCreatorPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProjectDraft(
            @RequestBody projectDraft: ProjectDraft
    ): Project = projectCreatorPort.createProjectDraft(projectDraft)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProjectWithFeatures(
            @RequestBody projectWithFeatures: ProjectWithFeatures
    ): Project = projectCreatorPort.createProjectWithFeatures(projectWithFeatures)


}