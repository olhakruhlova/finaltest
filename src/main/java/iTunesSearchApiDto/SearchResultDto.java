package iTunesSearchApiDto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;


@Jacksonized
@Data
public class SearchResultDto {
    private int resultCount;
    private List<ResultDto> results;
}
