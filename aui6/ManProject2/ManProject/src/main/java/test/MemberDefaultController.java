package test;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.UUID;

@RestController
@Log
@AllArgsConstructor
public class MemberDefaultController{

    private final MemberDefaultService memberService;
    private final MemberToResponseFunction memberToResponse;
    private final MembersToResponseFunction membersToResponse;
    private final RequestToMemberFunction requestToMember;

    @GetMapping("api/members")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMembersResponse getMembers() {
        return membersToResponse.apply(memberService.findAll());
    }

    @GetMapping("/api/projects/{projectId}/members")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMembersResponse getProjectMembers(@PathVariable UUID projectId) {
        return memberService.findAllByProject(projectId)
                .map(membersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMemberResponse getMember(@PathVariable UUID id) {
        return memberService.find(id)
                .map(memberToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putMember(@PathVariable UUID id, @RequestBody PutMemberRequest request) {
        memberService.create(requestToMember.apply(id, request));
    }

    @DeleteMapping("/api/members/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable UUID id) {
        memberService.find(id)
                .ifPresentOrElse(
                        member -> memberService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}