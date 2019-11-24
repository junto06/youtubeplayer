package com.vid90sec.videos.data.source.youtube.mapper

/**
 * Created by Mudassar Hussain on 11/25/2019.
 * DTO => Data Transfer Object
 */
interface YouTubeToDomainMapper<DTO,DOMAIN,DTOItem,DOMAINItem>{
    fun toDomain(from:DTO):DOMAIN
    fun toDomain(from:List<DTOItem>):List<DOMAINItem>
    fun toDomainItem(from:DTOItem):DOMAINItem
}