package vn.api.spring.business.application.issue.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteIssueInput {
  private int id;
}
