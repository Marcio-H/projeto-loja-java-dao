package domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneVendedor {
     
    @Id
    private Long id;
    
    @Column
    private String telefone;
    
    @ManyToOne
    private Vendedor vendedor;
}
