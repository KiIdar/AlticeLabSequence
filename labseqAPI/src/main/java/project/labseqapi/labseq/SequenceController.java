package project.labseqapi.labseq;

import dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/labseq")
public class SequenceController {
	
	private final SequenceService sequenceService;
	
	@Autowired
	public SequenceController(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}



	@Operation(description = "Returns a value from the labseq sequence.")
	@ApiResponses(
			value = {
					@ApiResponse(responseCode = "200"),
					@ApiResponse(responseCode = "400", description = "The number format was incorrect. Must be a non-negative integer.", content = @Content(schema = @Schema(implementation = Void.class)))
			}
	)
	@GetMapping("/{n}")
	public ResponseEntity<ResponseDTO> calculateLabSeq(@Parameter(description = "A non-negative integer number") @PathVariable int n)
	{
		ResponseDTO response = sequenceService.calculateLabSeq(n);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
