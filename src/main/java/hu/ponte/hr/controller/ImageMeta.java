package hu.ponte.hr.controller;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author zoltan
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="images")
public class ImageMeta
{
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="Id")
	private String id;
	@Column(name="Name")
	private String name;
	@Column(name="MimeType")
	private String mimeType;
	@Column(name="Size")
	private long size;
	@Column(name="Sign")
	private String digitalSign;
}
